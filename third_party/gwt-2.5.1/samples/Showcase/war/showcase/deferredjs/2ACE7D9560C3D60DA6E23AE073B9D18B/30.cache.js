function tI(a){this.a=a}
function zI(a){this.b=a}
function Zxb(){this.a=new uxc}
function EI(){throw new grc}
function XH(b,a){return b.b[jDc+a]}
function FI(a,b){this.a=a;this.b=b}
function ewb(a,b){this.a=a;this.b=b}
function WH(a,b){return iU(b,1)?XH(a,gU(b,1)):null}
function YH(a,b){var c;this.a=a;this.b={};for(c=0;c<a.length;++c){this.b[jDc+a[c]]=b[c]}}
function yI(a){var b;if(a.a>=a.b.a.a.length){throw new xyc}b=a.b.a.a[a.a++];return new FI(b,XH(a.b.a,b))}
function Yxb(a){var b;b=gU(a.a.ie(GLc),160);if(!b){b=new YH(YT(pdb,Yzc,1,[CJc,zJc,FJc,BJc,GJc,EJc,HLc,ILc]),YT(pdb,Yzc,1,[JLc,KLc,LLc,MLc,NLc,OLc,PLc,QLc]));a.a.ke(GLc,b)}return b}
function awb(a){var b,c,d,e,f,g,i,j,k,n,o,p,q,r;f=new Zxb;n=new W4b;i=gU(n.j,100);n.o[GGc]=5;q=Igb(v2);o=new HZb(q);kj(o,new ewb(a,q),(_w(),_w(),$w));p=new M6b;p.e[GGc]=3;J6b(p,new t2b("Cet exemple interagit avec l'\xE9chatillon de l'interface:"));J6b(p,o);Q4b(n,0,0,p);d5b(i,0)[uIc]=2;g=new tac;g.cb[vIc]='Amelie';rB(g.a);g.cb.style[TCc]=rLc;N4b(n,1,0,'<b>Pr\xE9nom:<\/b>');Q4b(n,1,1,g);k=new tac;k.cb[vIc]='Crutcher';rB(k.a);k.cb.style[TCc]=rLc;N4b(n,2,0,'<b>Nom:<\/b>');Q4b(n,2,1,k);b=new J7b;c=Yxb(f);for(e=c.he().Zb();e.te();){d=gU(e.ue(),161);j=gU(d.we(),1);r=gU(d.Lc(),1);F7b(b,r,j,-1)}N4b(n,3,0,'<b>Couleur Pr\xE9f\xE9r\xE9e:<\/b>');Q4b(n,3,1,b);return n}
var GLc='colorMap';reb(363,364,wAc,YH);_.fe=function ZH(a){return (iU(a,1)?XH(this,gU(a,1)):null)!=null};_.he=function $H(){return new tI(this)};_.ie=function _H(a){return iU(a,1)?XH(this,gU(a,1)):null};_.me=function aI(){return this.a.length};_.a=null;_.b=null;reb(365,366,yAc,tI);_.pe=function uI(a){var b,c;if(!iU(a,161)){return false}b=gU(a,161);c=WH(this.a,b.we());if(c!=null&&bqc(c,b.Lc())){return true}return false};_.Zb=function vI(){return new zI(this)};_.me=function wI(){return this.a.a.length};_.a=null;reb(368,1,{},zI);_.te=function AI(){return this.a<this.b.a.a.length};_.ue=function BI(){return yI(this)};_.ve=function CI(){throw new grc};_.a=0;_.b=null;reb(369,1,zAc,FI);_.eQ=function GI(a){var b;if(iU(a,161)){b=gU(a,161);if(bqc(this.a,b.we())&&bqc(this.b,b.Lc())){return true}}return false};_.we=function HI(){return this.a};_.Lc=function II(){return this.b};_.hC=function JI(){var a,b;a=0;b=0;this.a!=null&&(a=Gqc(this.a));this.b!=null&&(b=Gqc(this.b));return a^b};_.xe=function KI(a){return EI(gU(a,1))};_.tS=function LI(){return this.a+WDc+this.b};_.a=null;_.b=null;reb(655,1,IAc,ewb);_.Dc=function fwb(a){Bgb(this.a,this.b+CLc)};_.a=null;_.b=null;reb(656,1,LAc);_.lc=function jwb(){_gb(this.b,awb(this.a))};reb(681,1,{},Zxb);var v2=cpc(DHc,'ExampleConstants'),U1=apc(DHc,'CwConstantsExample$1',655),u2=apc(DHc,'ExampleConstants_fr',681),OZ=apc(SHc,'ConstantMap',363),NZ=apc(SHc,'ConstantMap$EntryImpl',369),MZ=apc(SHc,'ConstantMap$1',365),LZ=apc(SHc,'ConstantMap$1$1',368);yBc(wn)(30);