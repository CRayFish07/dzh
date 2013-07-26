window.slider_autoplaytimer = null;
window.slider_playcount = 0;

function init_pic(size, datas, ul_parent, foc_img, cn1, cn2, desc_info, titlebox, btnorg, prev, next, view_all, content_area, index) {
    index = index || 0;
    var delaywidth = 106;
    var slidecount = 6;
    var slidecount_small = 11;
    var big_con_height = parseInt(foc_img.parents('.content_area').height());
    ul_parent.css('width', datas.length * delaywidth + "px");

    $.appendDataDom(data, ul_parent);

    function aniScrollBar(n) {
        if (size == "big") {
            var foot = ($('.hScrollPane_dragbar').width() - $('.hScrollPane_draghandle').width()) / (datas.length - 6);
            $('.hScrollPane_draghandle').animate({ 'left': -1 * foot * n });
        } else {
            var foot = ($('.main_scrollbar').height() - $('.main_scrollbar a').height()) / (datas.length - 11);
            $('.main_scrollbar a').animate({ 'top': -1 * foot * n });
        }
    }
    function checkScroll(i) {
        if (size == "big") {
            var foot = 106,
                view_count = 6,
                max = Math.min(-1 * foot * (i - view_count + 1), 0),
                min = -1 * foot * i,
                cur_left = parseFloat(ul_parent.css('left'));
            if (cur_left > max) {
                ul_parent.animate({
                    left: max
                });
                aniScrollBar(view_count - 1 - i);
            } else if (cur_left < min) {
                ul_parent.animate({
                    left: min
                });
                aniScrollBar(-i);
            }
        } else {
            var foot = 57,
            view_count = 11,
                max = Math.min(-1 * foot * (i - view_count + 1), 0),
                min = -1 * foot * i,
                cur_top = parseFloat(ul_parent.css('top'));
            if (cur_top > max) {
                ul_parent.animate({
                    top: max
                });
                aniScrollBar(view_count - 1 - i);
            } else if (cur_top < min) {
                ul_parent.animate({
                    top: min
                });
                aniScrollBar(-i);
            }
        }
    }

    function play(i, isBeacon) {
        isBeacon = isBeacon || 'yes';
        if (i <= 0) {
            i = 0;
        }
        if (i >= (datas.length - 1)) {
            i = (datas.length - 1);
        }
        var old_index = window.slider_playcount;
        window.slider_playcount = i;

        desc_info.html(datas[i]['desc']);
        ul_parent.find('li').eq(i).addClass('on').siblings().removeClass('on');
        cn2.html(data.length);
        cn1.html(i + 1);
        titlebox.html(data[i]['title']);
        var imgUrl = datas[i]['orgl']['src'];
        var imgHeight = datas[i]['orgl']['h'];

        if (foc_img.attr('src') != imgUrl) { //fix blink for first image
            foc_img.one('load', function() {
                $(this).fadeIn(500);
            }).hide().attr('src', imgUrl);
        } else {
            foc_img.fadeIn(500);
        }

        if (size == 'big') { //vertical img in ie6
            var containerHeight = big_con_height;
            var cssFix = {};

            if (imgHeight < containerHeight) {
                cssFix = { 'padding-top': (containerHeight - imgHeight) / 2, 'height': imgHeight };
            } else {
                cssFix = { 'height': containerHeight, 'padding': 0 };
            }
            foc_img.css(cssFix);
        }
        checkScroll(i);

        $('#play_area_content').show();
        $('#suoluetu').hide();
        $('#play_over').hide();
        $('.gallery_desc').show();

        view_all.html('预览全部');
        if (isBeacon == 'yes' && typeof Beacon != 'undefined') {
            Beacon.ajax_refer = old_index + 1; // current index
            Beacon.ajax_url = i + 1; // target index
            Beacon.ajax_isLastPage = 0; // 0 or 1
            Beacon.ajaxRequest();
        }

        document.location.href = document.location.href.replace(document.location.hash, '') + "#" + (i + 1);
    }

    //next,prev add hover style
    prev.hover(function() { $(this).addClass('left_off'); }, function() { $(this).removeClass('left_off'); });
    next.hover(function() { $(this).addClass('right_off'); }, function() { $(this).removeClass('right_off'); });
    content_area.mousemove(function(e) {
        var ex = e.clientX;
        var flag = $(this).offset().left + $(this).width() / 2;
        if (ex > flag) {
            next.addClass('right_off');
            prev.removeClass('left_off');
        } else {
            prev.addClass('left_off');
            next.removeClass('right_off');
        }
    });


    ul_parent.find('li').live('click', function(e) {
        var i = $(this).index();
        play(i);
        e.preventDefault();
    });

    btnorg.live('click', function() {
        $(this).attr('href', datas[window.slider_playcount]['orgl']['src']);
    });


    prev.live('click', function() {
        window.slider_playcount = window.slider_playcount - 1;
        if (window.slider_playcount < 0) {
            //if (size == "small") {
            var prev_gallery_url = $('#prev_gallery').attr('href');
            window.location.href = prev_gallery_url;
            return false;
            //}
        }
        play(window.slider_playcount);
    });

    next.live('click', function() {
        window.slider_playcount = window.slider_playcount + 1;
        if (size == "big") {
            if (window.slider_playcount == datas.length) {
                paly_over();
                return false;
            }
            if (window.slider_playcount > datas.length) {
                var next_gallery_url = $('#next_gallery').attr('href');
                window.location.href = next_gallery_url;
                return false;
            }
        } else {
            if (window.slider_playcount == datas.length) {
                //play next group
                var next_gallery_url = $('#next_gallery').attr('href');
                window.location.href = next_gallery_url;
                return false;
            }
        }
        play(window.slider_playcount);
    });

    content_area.click(function(e) {
        var ex = e.clientX;
        var flag = $(this).offset().left + $(this).width() / 2;
        if (ex > flag) {
            next.click();
        } else {
            prev.click();
        }
    });

    document.onkeydown = function(e) {
        var e = window.event ? window.event : e;
        if (e.keyCode == 37) {
            prev.click();
        }
        if (e.keyCode == 39) {
            next.click();
        }
    }

    //加载滚动条
    if (size == 'big') {
        $(".img_list").sliderDrag({
            mover: $('#thumblist'),
            hander: {
                'b': $('.hScrollPane_dragbar'),
                'v': $('.hScrollPane_draghandle')
            },
            gap: 8,
            hoverStyle: 'vernier_hover',
            handerWidth: 153,
            direction: 0 //0 是横向 1为纵向
        });

    } else {
        $(".main_img_list").sliderDrag({
            mover: $('#thumbimglist'),
            hander: {
                'b': $('.main_scrollbar'),
                'v': $('.main_scrollbar a')
            },
            gap: 9,
            handerWidth: 152,
            hoverStyle: 'vernier_hover',
            direction: 1 //0 是横向 1为纵向
        });


        function setAutoplay() {
            if (window.autopalytimer) {
                clearInterval(window.autopalytimer);
            }
            $('#small_thumb_list_content').hide();
            $('#small_play_content').show();
            window.autopalytimer = setInterval(function() {
                //play(window.slider_playcount);
                next.click();
                /*if (window.slider_playcount == (datas.length-1)) {
                window.slider_playcount = 0;
                } else {
                window.slider_playcount++;
                }*/
                //console.log( data.length);
            }, getDelayTime() * 1000);
        }

        function stopAutoPlay() {
            if (window.autopalytimer) {
                clearInterval(window.autopalytimer);
                $('#s_autoPlay_stop').hide();
                $('#s_autoPlay_count').hide();
                $('.s_autoPlayBtn').show();
            }

        }

        function getDelayTime() {
            return parseInt($('#s_ipt_time').val());
        }

        $('#s_autoPlay_count .up').live('click', function() {
            if ($('#s_ipt_time').val() < 5) {
                var psecond = parseInt($('#s_ipt_time').val()) + 1;
                $('#s_ipt_time')[0].value = psecond;
                setAutoplay();
            }
        });

        $('#s_autoPlay_count .down').live('click', function() {
            if ($('#s_ipt_time').val() > 1) {
                var psecond = parseInt($('#s_ipt_time').val()) - 1;
                $('#s_ipt_time')[0].value = psecond;
                setAutoplay();
            }
        });

        $('#s_autoPlay_stop').live('click', function() {
            stopAutoPlay();
        });

        $('.s_autoPlayBtn').click(function() {
            $(this).hide();
            $('#s_autoPlay_stop').show();
            $('#s_autoPlay_count').show();
            setAutoplay();
        });
    }
    play(index, 'no');

    //查看全部
    view_all.toggle(function() {
        if (window.autopalytimer) {
            stopAutoPlay();
        }

        $(this).html('返回原图');
        if (size == "big") {
            $('#play_area_content').hide();
            $('#suoluetu').find('ul').html('');
            $.appendDataDom(data, $('#suoluetu').find('ul'));
            $('#suoluetu').fadeIn().css('height', 'auto');
            $('#suoluetu a').attr('href', 'javascript:void(0);');
        } else {
            $('#main_body_list').html('');
            $.appendDataDom(data, $('#main_body_list'));
            $('#small_play_content').hide();
            $('#small_thumb_list_content').fadeIn(500);
            $('#main_body_list a').attr('href', 'javascript:void(0);');
            $("#small_thumb_list_content").sliderDrag({
                mover: $('#main_body_list'),
                hander: {
                    'b': $('.main_scrollbar2'),
                    'v': $('.main_scrollbar2 a')
                },
                gap: 24,
                handerWidth: 152,
                hoverStyle: 'vernier_hover',
                direction: 1
            });
        }
        //check the last page
        $('#play_over').hide();
        $('.gallery_desc').show();

    }, function() {
        $(this).html('预览全部');
        if (size == "big") {
            $('#play_area_content').fadeIn();
            $('#suoluetu').hide();
        } else {
            $('#main_body_list').html('');
            $('#small_play_content').show();
            $('#small_thumb_list_content').hide();

        }
    });


    $('#suoluetu li').live('click', function(e) {
        //var historycount = window.slider_playcount;
        window.slider_playcount = $(this).index();

        play(window.slider_playcount);
        view_all.click();
        /*
        if (window.slider_playcount >= 6) {
            var m = Math.floor(window.slider_playcount / 6) * 6;
            checkScrollTo(m, 1); console.log(checkScrollTo.toString())
        }
        */
        e.preventDefault();
    }).live('mouseenter', function() {
        $(this).addClass('on');
    }).live('mouseleave', function() {
        if ($(this).index() != window.slider_playcount) {
            $(this).removeClass('on');
        }
    });

    $('#main_body_list li').live('click', function() {
        window.slider_playcount = $(this).index();
        play(window.slider_playcount);
        view_all.click();

        $('#small_play_content').show();
        $('#small_thumb_list_content').hide();
        /*
        if (window.slider_playcount >= 11) {
            var m = Math.floor(window.slider_playcount / 11) * 11;
            checkScrollTo(m, 1);
        }
        */
    }).live('mouseenter', function() {
        $(this).addClass('on');
    }).live('mouseleave', function() {
        if ($(this).index() != window.slider_playcount) {
            $(this).removeClass('on');
        }
    });


    $('.replay').click(function() {
        $('#thumblist li').eq(0).click();
        $('.hScrollPane_draghandle').css('left', '0');
        $('#thumblist').css('left', '0');
    });

    $('.replay,.left_top span.share2').mouseenter(function() { $(this).addClass('hover'); }).mouseleave(function() {
        $(this).removeClass('hover');
    });

    //console.log(GetCookie('newspic_light'));
    if ($('#style_obj_2').attr('media') == 'print') {
        $('#off_light').html('关灯');
    } else {
        $('#off_light').html('开灯');
    }
    $('#off_light').live('click', function() {
        if ($('#style_obj_2').attr('media') == 'print') {
            $('#style_obj_2').removeAttr('media');
            $(this).html('开灯');
            $('#style_obj_2').attr('disabled', false);
            SetCookie('newspic_light', 'off', 720);
        } else {
            if ($('#style_obj_2').attr('disabled') == false) {
                $(this).html('关灯');
                $('#style_obj_2').attr('disabled', true);
                SetCookie('newspic_light', 'on', 720);
            } else {
                $(this).html('开灯');
                $('#style_obj_2').attr('disabled', false);
                SetCookie('newspic_light', 'off', 720);
            }
        }
    });
}

function returnFalse(){
	return false;
}

$.appendDataDom = function(datas, parent) {
    var str = "";
    for (var i = 0; i < data.length; i++) {
        if (i == window.slider_playcount) {
            str += '<li class="on"><a style="background:url(' + datas[i]['thumb']['src'] + ') no-repeat top center;" href="javascript:returnFalse();"></a></li>';
        } else {
            str += '<li><a style="background:url(' + datas[i]['thumb']['src'] + ') no-repeat top center;" href="javascript:returnFalse();"></a></li>';
        }
    }
    parent.html('');
    parent.append(str);
}

function paly_over() {
    $('#play_area_content').hide();
    $('#suoluetu').hide();
    $('#play_over').show();
    $('.gallery_desc').hide();

    var old_index = window.slider_playcount;
    if (typeof Beacon != 'undefined') {
        Beacon.ajax_refer = old_index; // current index
        Beacon.ajax_url = old_index + 1; // target index
        Beacon.ajax_isLastPage = 0; // 0 or 1
        Beacon.ajaxRequest();
    }
}
