var domain = "http://www.gzb.com" ;
var title = "标题" ;
function addCookie() { // 加入收藏
	if (document.all) {
		window.external.addFavorite(domain, title);
	} else if (window.sidebar) {
		window.sidebar.addPanel(title,domain, "");
	}
}
function setHomepage() { // 设为首页
	if (document.all) {
		document.body.style.behavior = 'url(#default#homepage)';
		document.body.setHomePage(domain);
	} else if (window.sidebar) {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				alert("该操作被浏览器拒绝，假如想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true");
			}
		}
		var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
		prefs.setCharPref('browser.startup.homepage',domain);
	}
}
