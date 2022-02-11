//鑷畾涔塵yChildren鍑芥暟
Element.prototype.myChildren=function(){
    var child=this.childNodes;
    var length=child.length;
    var mychild=[];
    for(var i=0;i<length;i++){
        if(child[i].nodeType==1){
            mychild.push(child[i]);
        }
    }
    return mychild;
}
var qiXi=function(){
    var confi = {
        //闊充箰鍙傛暟
        audio: {
            enable: true, // 鏄惁寮€鍚煶涔?
            audio1:document.getElementById('audio1'), // 姝ｅ父鎾斁鍦板潃
            audio2:document.getElementById('audio2') // 姝ｅ父寰幆鎾斁鍦板潃
        },
        //鏃堕棿鎺у埗
        setTime: {
            walkToThird: 6000,
            walkToMiddle: 6500,
            walkToEnd: 6500,
            walkTobridge: 1200,
            bridgeWalk: 1800,
            walkToShop: 1500,
            walkOutShop: 1500,
            openDoorTime: 800,
            shutDoorTime: 500,
            waitRotate: 1800
        },
        //鑺辩摚閾炬帴鏁扮粍
        snowflakeURl: ["http://static.51bbw.cn/temp/6/img/snow1.png",
            "http://static.51bbw.cn/temp/6/img/snow2.png",
            "http://static.51bbw.cn/temp/6/img/snow3.png",
            "http://static.51bbw.cn/temp/6/img/snow4.png",
            "http://static.51bbw.cn/temp/6/img/snow5.png",
            "http://static.51bbw.cn/temp/6/img/snow6.png"]
    };
    var instanceX;
    var container=document.getElementById('content');
    var visualWidth=container.offsetWidth,
        visualHeight=container.offsetHeight;
    var getValue=function(className){
        var elem=document.getElementsByClassName(className)[0];
        return{
            height:elem.offsetHeight,
            top:elem.offsetTop
        };
    };
    //璺殑Y杞?
    var pathY=function(){
        var data=getValue('a_background_middle');
        return data.top+data.height/2;
    }();
    //妗ョ殑Y杞?
    var bridgeY=function(){
        var data=getValue('c_background_middle');
        return data.top;
    }();
    if (confi.audio.enable) {
        //   var audio1 = Html5Audio(confi.audio.audio1);
        // audio1.end(function() {
        //     Html5Audio(confi.audio.audio2)
        // })
    }
    var swipe = Swipe(container);
    function scrollTo(time,proportionX){
        var distX=visualWidth*proportionX;
        swipe.scrollTo(distX,time);
    }
    //灏忓コ瀛?
    var girl={
        elem:document.getElementsByClassName('girl')[0],
        getHeight: function() {
            return this.elem.offsetHeight;
        },
        rotate:function(){
            this.elem.classList.add('girl-rotate');
        },
        setOffset:function(){
            this.elem.style.cssText+="left:"+(visualWidth/2)+"px;top:"+(bridgeY-this.getHeight())+"px;"
        },
        getOffset:function(){
            return this.elem.getBoundingClientRect()
        },
        getWidth:function(){
            return this.elem.offsetWidth;
        }
    };
    //灏忛笩
    var bird={
        elemBird:document.getElementsByClassName('bird')[0],
        fly:function(){
            this.elemBird.classList.add('birdFly');
            this.elemBird.style.cssText+="transition: right 15000ms linear;";
            this.elemBird.style.right=visualWidth+"px";
        }
    };
    //logo鍔ㄧ敾
    var logo={
        elem:document.getElementsByClassName('logo')[0],
        run:function(){
            this.elem.classList.add('logolightSpeedIn')
        }
    }
    var content={
        elem:document.getElementsByClassName('content_text')[0],
        run:function(){
            this.elem.classList.add('logolightSpeedIn')
        }
    }
    var boy = BoyWalk();
    boy.walkTo(confi.setTime.walkToThird, 0.6).then(function() {
        scrollTo(confi.setTime.walkToMiddle, 1);
        return boy.walkTo(confi.setTime.walkToMiddle, 0.5)
    }).then(function() {
        bird.fly()
    }).then(function() {
        boy.stopWalk();
        return BoyToShop(boy)
    }).then(function() {
        girl.setOffset();
        scrollTo(confi.setTime.walkToEnd, 2);
        return boy.walkTo(confi.setTime.walkToEnd, 0.15)
    }).then(function() {
        return boy.walkTo(confi.setTime.walkTobridge, 0.25, (bridgeY - girl.getHeight()) / visualHeight)
    }).then(function() {
        var proportionX = (girl.getOffset().left - boy.getWidth()+girl.getWidth()/2-instanceX) / visualWidth;
        return boy.walkTo(confi.setTime.bridgeWalk, proportionX)
    }).then(function() {
        boy.resetOriginal();
        setTimeout(function() {
                girl.rotate();
                boy.rotate(function() {
                    logo.run();
                    content.run();
                    snowflake();
                })
            },
            confi.setTime.waitRotate)
    });
    function BoyWalk(){
        var boy=document.getElementById('boy');
        var boyHeight=boy.offsetHeight;
        var boyWidth=boy.offsetWidth;
        //淇灏忕敺瀛╃殑浣嶇疆
        boy.style.cssText+="top:"+(pathY-boyHeight+25)+"px";
        //鏆傚仠
        function pauseWalk() {
            boy.classList.add("pauseWalk");
        }
        //鎭㈠
        function restoreWalk() {
            boy.classList.remove("pauseWalk");
        }
        //鐢╰ransition鍋氬姩鐢?
        function startRun(options,runTime){
            var p=new Promise(function(resolve,reject){ //瑙ｅ喅浜嗗紓姝ュ洖璋冨嚱鏁板眰灞傚祵濂楃殑闂
                boy.classList.remove('pauseWalk');
                var keys=""; //绌哄瓧绗︿覆
                for(var key in options){
                    keys+=key+",";
                }
                keys=keys.substring(0,keys.length-1); //鍘绘帀鏈€鍚庣殑鍒嗗彿
                boy.style.transitionProperty=keys;
                boy.style.transitionDuration=runTime+"ms";
                boy.style.transitionTimingFunction="linear";
                boy.style.left=options.left;
                boy.style.top=options.top;
                boy.style.opacity=options.opacity;
                boy.style.transform=options.transform;
                setTimeout(function(){
                    resolve();
                },runTime)
            });
            return p;
        }
        //寮€濮嬭蛋璺?
        function walkRun(time,distX,distY){
            time=time||3000;
            boy.classList.add('slowWalk');
            var d1=startRun({
                'left':distX+"px",
                'top':(distY?distY:undefined)+"px"
            },time);
            return d1;
        }
        //璧拌繘鍟嗗簵
        function walkToShop(runTime){
            var p1=new Promise(function(resolve,reject){
                var doorObj=document.getElementsByClassName('door')[0];
                var doorPos=doorObj.getBoundingClientRect(); //鐩稿浜庣獥鍙ｇ殑浣嶇疆
                var boyPos=boy.getBoundingClientRect();
                var doorLeft=doorPos.left;
                var doorWidth=doorPos.width;
                var boyLeft=boyPos.left;
                var boyWidth=boyPos.width;
                //褰撳墠闇€瑕佺Щ鍔ㄧ殑搴ф爣
                instanceX = (doorLeft+doorWidth/2) - (boyLeft + boyWidth/ 2);
                var walkPlay=startRun({
                    transform: 'translateX(' + instanceX + 'px) scale(0.3,0.3)',
                    opacity: 0.1
                }, runTime);
                walkPlay.then(function(){
                    boy.style.opacity=0;
                    resolve();
                })
            });
            return p1;
        }
        //璧板嚭鍟嗗簵
        function walkOutShop(runTime) {
            var p1=new Promise(function(resolve,reject){
                boy.classList.remove("pauseWalk");
                startRun({
                    transform: 'translateX(' + instanceX + 'px) scale(1,1)',
                    opacity: 1
                },runTime);
                setTimeout(function(){
                    resolve();
                },runTime);
            });
            return p1;
        }
        //璁＄畻绉诲姩璺濈
        function calculateDistance(direction,proportion){
            return(direction=="x"?visualWidth:visualHeight)*proportion;
        }
        return{
            //寮€濮嬭蛋璺?
            walkTo:function(time,proportionX,proportionY){
                var distX=calculateDistance('x',proportionX);
                var distY=calculateDistance('y',proportionY);
                return walkRun(time,distX,distY);
            },
            toShop:function(runTime){
                return walkToShop(runTime);
            },
            outShop: function(runTime) {
                return walkOutShop(runTime);
            },
            stopWalk:function(){
                boy.classList.add('pauseWalk');
            },
            setColor:function(value){
                boy.style.cssText+="background-color: "+value+";";
            },
            getWidth: function() {
                return boyWidth;
            },
            getDistance: function() {
                return boy.getBoundingClientRect().left;
            },
            resetOriginal:function(){
                this.stopWalk();
                boy.classList.remove('slowWalk');
                boy.classList.remove('slowFlowerWalk');
                boy.classList.add('boyOriginal');
            },
            takeFlower:function(){
                boy.classList.add('slowFlowerWalk');
            },
            rotate:function(callback){
                boy.classList.remove('pauseWalk');
                boy.classList.add('boy-rotate');
                if(callback){
                    callback();
                }
            }
        }
    }
    var BoyToShop = function(boyObj) {
        var p2= new Promise(function(resolve,reject){
            var door=document.getElementsByClassName('door')[0],
                doorLeft=document.getElementsByClassName('door-left')[0],
                doorRight=document.getElementsByClassName('door-right')[0];
            function doorAction(left,right,time){
                var p= new Promise(function(resolve,reject){
                    doorLeft.style.transitionProperty="left";
                    doorLeft.style.transitionDuration=time+"ms";
                    doorLeft.style.left=left;
                    doorRight.style.transitionProperty="left";
                    doorRight.style.transitionDuration=time+"ms";
                    doorRight.style.left=right;
                    setTimeout(function(){
                        resolve();
                    },time)
                });
                return p;
            }
            function openDoor(time){
                return doorAction("-50%","100%",time);
            }
            function shutDoor(time){
                return doorAction("0%","50%",time);
            }

            //鍙栬姳
            function takeFlower(){
                var p1=new Promise(function(resolve,reject){
                    setTimeout(function(){
                        var boy=document.getElementById('boy');
                        boy.classList.add('slowFlowerWalk');
                        resolve();
                    },1500)
                });
                return p1;
            }
            var lamp = {
                elem: document.getElementsByClassName('b_background')[0],
                bright: function() {
                    this.elem.classList.add("lamp-bright")
                },
                dark: function() {
                    this.elem.classList.remove("lamp-bright")
                }
            };
            var waitOpen = openDoor(confi.setTime.openDoorTime);
            waitOpen.then(function() {
                lamp.bright();
                return boyObj.toShop(confi.setTime.walkToShop)
            }).then(function() {
                return takeFlower()
            }).then(function() {
                return boyObj.outShop(confi.setTime.walkOutShop)
            }).then(function() {
                shutDoor(confi.setTime.shutDoorTime);
                lamp.dark();
                resolve();
            });
        });

        return p2;
    };
//椋橀洩鑺?
    function snowflake(){
        //闆姳瀹瑰櫒
        var snowContainer=document.getElementById('snowflake');
        //闅忔満鍏紶鍥?
        function getImagesName(){
            return confi.snowflakeURl[Math.floor(Math.random() * 6)]
        }
        //鍒涘缓涓€涓洩鑺卞厓绱?
        function createSnowBox(){
            var url=getImagesName();
            var elem=document.createElement('div');
            elem.style.backgroundImage="url("+url+")";
            elem.classList.add('snowRoll');
            return elem;
        }
        //寮€濮嬮鑺?
        setInterval(function(){
            //杩愬姩鐨勮建杩?
            var startPositionLeft = Math.random() * visualWidth - 100,
                startOpacity = 1,
                endPositionTop = visualHeight - 40,
                endPositionLeft = startPositionLeft - 100 + Math.random() * 500,
                duration =  Math.random() * 5 + 5 + "s";
            //闅忔満閫忔槑搴?,涓嶅皬浜?0.5
            var randomStart = Math.random();
            randomStart = randomStart < 0.5 ? startOpacity: randomStart;
            //鍒涘缓涓€涓洩鑺?
            var newSnowItem=createSnowBox();
            //璁捐璧风偣浣嶇疆
            newSnowItem.style.left=startPositionLeft+"px";
            newSnowItem.style.opacity=randomStart;
            //鍔犲叆鍒板鍣?
            snowContainer.appendChild(newSnowItem);
            //寮€濮嬫墽琛屽姩鐢?
            newSnowItem.style.transitionProperty="top,opacity";
            newSnowItem.style.transitionDuration=duration;
            setTimeout(function(){
                newSnowItem.style.left = endPositionLeft +"px";
                newSnowItem.style.top = endPositionTop +"px";
                newSnowItem.style.opacity = 1;
            },100)
            setTimeout(function(){
                snowContainer.removeChild(newSnowItem);
            },10000)
        },100);
    }
// 	function Html5Audio(audioobj) {
// 		var audio=audioobj;
// 	//	audio.play();
// 		return{
// 			end:function(callback){
// 				audio.addEventListener('ended',function(){
// 					callback();
// 				},false);
// 			}
// 		};
// 	}
}
window.onload=function(){
    qiXi()
};
//椤甸潰婊戝姩
function Swipe(container,options){
    //鑾峰彇绗竴涓瓙鑺傜偣
    var ele=document.getElementsByClassName('content_wrap')[0];
    //婊戝姩瀵硅薄
    var swipe={};
    //li椤甸潰鏁伴噺
    var slides=ele.myChildren();
    //鑾峰彇瀹瑰櫒灏哄
    var width=container.offsetWidth,
        height=container.offsetHeight;
    //璁剧疆Li椤甸潰鎬诲搴?
    ele.style.cssText="height:"+height+"px;width:"+width*slides.length+"px;";
    //璁剧疆姣忎竴涓〉闈i鐨勫搴?
    for(var i=0;i<slides.length;i++){
        slides[i].style.cssText+="width:"+width+"px;height:"+height+"px";
    }
    //鐩戞帶瀹屾垚涓庣Щ鍔?
    swipe.scrollTo=function(x,speed){
        ele.style.cssText+="transition-timing-function: linear;transition-duration:"+speed+"ms;transform: translate3d(-"+x+"px,0px,0px)";
        return this;
    }
    return swipe;
}