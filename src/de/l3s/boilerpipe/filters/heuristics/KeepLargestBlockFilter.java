// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

/**
 * boilerpipe
 *
 * Copyright (c) 2009 Christian Kohlschütter
 *
 * The author licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.l3s.boilerpipe.filters.heuristics;

import com.google.gwt.dom.client.Element;

import de.l3s.boilerpipe.BoilerpipeFilter;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.document.TextBlock;
import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.labels.DefaultLabels;

import java.util.List;
import java.util.ListIterator;

/**
 * Keeps the largest {@link TextBlock} only (by the number of words). In case of
 * more than one block with the same number of words, the first block is chosen.
 * All discarded blocks are marked "not content" and flagged as
 * {@link DefaultLabels#MIGHT_BE_CONTENT}.
 *
 * Note that, by default, only TextBlocks marked as "content" are taken into consideration.
 *
 * @author Christian Kohlschütter
 */
public final class KeepLargestBlockFilter implements BoilerpipeFilter {
    public static final KeepLargestBlockFilter INSTANCE = new KeepLargestBlockFilter(
            false);
    public static final KeepLargestBlockFilter INSTANCE_EXPAND_TO_SIBLINGS = new KeepLargestBlockFilter(
            true);
    private final boolean expandToSiblings;

    public KeepLargestBlockFilter(boolean expandToSiblings) {
        this.expandToSiblings = expandToSiblings;
    }

    @Override
    public boolean process(final TextDocument doc)
            throws BoilerpipeProcessingException {
        List<TextBlock> textBlocks = doc.getTextBlocks();
        if (textBlocks.size() < 2) {
            return false;
        }

        int maxNumWords = -1;
        TextBlock largestBlock = null;

        int i = 0;
        int largestBlockIndex = -1;
        for (TextBlock tb : textBlocks) {
            if (tb.isContent()) {
                final int nw = tb.getNumWords();

                if (nw > maxNumWords) {
                    largestBlock = tb;
                    maxNumWords = nw;
                    largestBlockIndex = i;
                }
            }
            i++;
        }
        for (TextBlock tb : textBlocks) {
            if (tb == largestBlock) {
                tb.setIsContent(true);
                tb.addLabel(DefaultLabels.VERY_LIKELY_CONTENT);
            } else {
                tb.setIsContent(false);
                tb.addLabel(DefaultLabels.MIGHT_BE_CONTENT);
            }
        }

        if (expandToSiblings && largestBlockIndex != -1) {
            maybeExpandContentToLaterTextBlocks(textBlocks, largestBlock, largestBlockIndex);
            maybeExpandContentToEarlierTextBlocks(textBlocks, largestBlock, largestBlockIndex);
        }

        return true;
    }

    private static void maybeExpandContentToEarlierTextBlocks(List<TextBlock> textBlocks,
            TextBlock largestBlock, int largestBlockIndex) {
        Element firstTextElement = largestBlock.getFirstNonWhitespaceTextElement().getParentElement();
        for (ListIterator<TextBlock> it = textBlocks.listIterator(largestBlockIndex);
                it.hasPrevious();) {
            TextBlock candidate = it.previous();
            if (candidate.getNonWhitespaceTextElements().size() < 1) {
                // This seems unnecessary but it's possible that a text block is empty.
                continue;
            }
            Element candidateLastTextElement = candidate.getLastNonWhitespaceTextElement().getParentElement();
            if (isSibling(firstTextElement, candidateLastTextElement)) {
                candidate.setIsContent(true);
                candidate.addLabel(DefaultLabels.SIBLING_OF_MAIN_CONTENT);
                firstTextElement = candidate.getFirstNonWhitespaceTextElement().getParentElement();
            }
        }
    }

    private static void maybeExpandContentToLaterTextBlocks(List<TextBlock> textBlocks,
            TextBlock largestBlock, int largestBlockIndex) {
        Element lastTextElement = largestBlock.getLastNonWhitespaceTextElement().getParentElement();
        for (ListIterator<TextBlock> it = textBlocks.listIterator(largestBlockIndex + 1);
                it.hasNext();) {
            TextBlock candidate = it.next();
            if (candidate.getNonWhitespaceTextElements().size() < 1) {
                // This seems unnecessary but it's possible that a text block is empty.
                continue;
            }
            Element candidateFirstTextElement = candidate.getFirstNonWhitespaceTextElement().getParentElement();
            if (isSibling(lastTextElement, candidateFirstTextElement)) {
                candidate.setIsContent(true);
                candidate.addLabel(DefaultLabels.SIBLING_OF_MAIN_CONTENT);
                lastTextElement = candidate.getLastNonWhitespaceTextElement().getParentElement();
            }
        }
    }

    private static boolean isSibling(Element e, Element other) {
        return e.getParentElement().equals(other.getParentElement());
    }
}