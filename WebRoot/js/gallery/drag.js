(function($){
	$.fn.sliderDrag = function(opts){
		this.each(function(){
			var contenter = $(this),
				mover = opts.mover,
				dragRange = opts.hander.b,
				hander = opts.hander.v;
			
			var w,c;
			
			//处理游标宽度、长度  显示、隐藏问题
			
			var dn = false;
			if (opts.direction == 0) {
				dn = true;
			} else {
				dn = false;
			}
			
			if (dn) {//横向
				w = contenter.width();
				c = mover.width()-opts.gap;	
				if (c>w) {
					if (opts.handerWidth) {
						hander.css('width',opts.handerWidth);	
					} else {
						hander.css('width',(w/c)*w);
					}
					hander.show();
				} else {
					hander.hide();
				}
				
			} else {
				w = contenter.height();
				c = mover.height()-opts.gap;
				if (c>w) {
					if (opts.handerWidth) {
						hander.css('height',opts.handerWidth);	
					} else {
						hander.css('height',(w/c)*w);
					}
					hander.show();
				} else {
					hander.hide();
				}
			}
			
			//给游标绑定hover事件
			hander.hover(function(){
				$(this).addClass(opts.hoverStyle);
			},function(){
				$(this).removeClass(opts.hoverStyle);
			});
			
			//回调拖拽
			var container = document.getElementById('container');
			var ele =hander[0];
			var bodyWidth = contenter.width(),
				bodyHeight = contenter.height();
			var maxX = bodyWidth - hander.width();
			var maxY = bodyHeight - hander.height();
			
			//处理移动
			var dd = new Dragdrop({
				target : ele,
				area : [0,maxX,0,maxY],
				callback : function(obj){
					if (dn) {
						var ulleft = obj.moveX / (w - hander.width()) * (c - w);
						mover.css('left',-ulleft);
					} else {
						var ultop = obj.moveY / (w - hander.height()) * (c - w);
						mover.css('top',-ultop);
					}
				}
			});	
			
			if (dn) {
				dd.dragX();
			} else {
				dd.dragY();
			}
			
		});
	};
})(jQuery);


/*拖拽函数*/	
	Dragdrop = function(window){
	var doc = window.document;
	var E = {
		on : function(el, type, fn){
			el.addEventListener ?
				el.addEventListener(type, fn, false) :
			el.attachEvent ?
				el.attachEvent("on" + type, fn) :
			el['on'+type] = fn;
		},
		un : function(el,type,fn){
			el.removeEventListener ?
				el.removeEventListener(type, fn, false) :
			el.detachEvent ?
				el.detachEvent("on" + type, fn) :
			el['on'+type] = null;
		},
		evt : function(e){
			return e || window.event;
		}
	};
	return function(opt){
		
		var conf = null, defaultConf, diffX, diffY;
		function Config(opt){
			this.target = opt.target;
			this.bridge = opt.bridge;
			this.dragable = opt.dragable != false;
			this.dragX = opt.dragX != false;
			this.dragY = opt.dragY != false;
			this.area  = opt.area;
			this.callback = opt.callback;
		}	
		function Dragdrop(opt){
			if(!opt){return;}
			conf = new Config(opt);
			defaultConf = new Config(opt);
			conf.bridge ?
				E.on(conf.bridge,'mousedown',mousedown) :
				E.on(conf.target,'mousedown',mousedown);
		}
		Dragdrop.prototype = {
			dragX : function(){
				conf.dragX = true;
				conf.dragY = false;
			},
			dragY : function(b){
				conf.dragY = true;
				conf.dragX = false;
			},
			dragAll : function(){
				conf.dragX = true;
				conf.dragY = true;
			},
			setArea : function(a){
				conf.area = a;
			},
			setBridge : function(b){
				conf.bridge = b;
			},
			setDragable : function(b){
				conf.dragable = b;
			},
			reStore : function(){
				conf = new Config(defaultConf);
				conf.target.style.top = '0px';
				conf.target.style.left = '0px';
			},
			getDragX : function(){
				return conf.dragX;
			},
			getDragY : function(){
				return conf.dragY;
			},
			disAbleDrag : function(){
				
				conf.dragX = false;
				conf.fragY = false;
			}
		}
		function mousedown(e){
			e = E.evt(e);
			var el = conf.target;
			el.style.position = 'absolute';
			
			if(el.setCapture){ //IE
				E.on(el, "losecapture", mouseup);
				el.setCapture();
				e.cancelBubble = true;
			}else if(window.captureEvents){ //标准DOM
				e.stopPropagation();
				E.on(window, "blur", mouseup);
				e.preventDefault();
			}
			diffX = e.clientX - el.offsetLeft;
			diffY = e.clientY - el.offsetTop;
			E.on(doc,'mousemove',mousemove);
			E.on(doc,'mouseup',mouseup);
		}
		function mousemove(e){
			var el = conf.target, e = E.evt(e), moveX = e.clientX - diffX, moveY = e.clientY - diffY;
			var minX, maxX, minY, maxY;
			if(conf.area){
				minX = conf.area[0];
				maxX = conf.area[1];
				minY = conf.area[2];
				maxY = conf.area[3];
				moveX < minX && (moveX = minX); // left 最小值
				moveX > maxX && (moveX = maxX); // left 最大值
				moveY < minY && (moveY = minY); // top 最小值
				moveY > maxY && (moveY = maxY); // top 最大值
			}
			if(conf.dragable){
				conf.dragX && (el.style.left = moveX + 'px');
				conf.dragY && (el.style.top =  moveY + 'px');
				if(conf.callback){
					var obj = {moveX:moveX,moveY:moveY};
					conf.callback.call(conf,obj);
				}
			}
		}
		function mouseup(e){
			var el = conf.target;
			
			E.un(doc,'mousemove',mousemove);
			E.un(doc,'mouseup',mouseup);
			if(el.releaseCapture){ //IE
				E.un(el, "losecapture", mouseup);
				el.releaseCapture();
			}
			if(window.releaseEvents){ //标准DOM
				E.un(window, "blur", mouseup);
			}
		}
		return new Dragdrop(opt);
		
	}
		
	}(this);