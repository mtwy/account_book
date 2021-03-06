<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>主页</title>

<meta name="description" content="A three dimensional and space efficient menu created with JavaScript and CSS 3.">
<meta name="author" content="Hakim El Hattab">

<meta name="viewport" content="width=800, user-scalable=no">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">
</head>
<body>
     <%@ include file="main.jsp" %> 

		<div class="contents">
		<li class=""><a title="" href="login.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
			<article>
				<h1>Meny</h1>
				<p>
					A three dimensional and space efficient menu.
				</p>
				<p>
					Move your mouse towards the arrow &mdash; or swipe in from the arrow if you're on a touch device &mdash; to open.	
				</p>
				<p>
					Meny can be positioned on any side of the screen: <br>
					 <a href="#">top</a>
					 - <a href="login.jsp">right</a>
					 - <a href="#">bottom</a>
					 - <a href="#">left</a>
				</p>
				<p>
					Instructions and download .
				</p>
				<p>
					The name, <em>Meny</em>, is swedish.
				</p>
				<small>
					Created by hakim.se</a>
				</small>
			</article>
		</div>

		<script src="${pageContext.request.contextPath}/js/meny.js"></script>
		<script>
			// Create an instance of Meny
			var meny = Meny.create({
				// The element that will be animated in from off screen
				menuElement: document.querySelector( '.meny' ),

				// The contents that gets pushed aside while Meny is active
				contentsElement: document.querySelector( '.contents' ),

				// [optional] The alignment of the menu (top/right/bottom/left)
				position: Meny.getQuery().p || 'left',

				// [optional] The height of the menu (when using top/bottom position)
				height: 200,

				// [optional] The width of the menu (when using left/right position)
				width: 260,

				// [optional] Distance from mouse (in pixels) when menu should open
				threshold: 40,

				// [optional] Use mouse movement to automatically open/close
				mouse: true,

				// [optional] Use touch swipe events to open/close
				touch: true
			});

			// API Methods:
			// meny.open();
			// meny.close();
			// meny.isOpen();

			// Events:
			// meny.addEventListener( 'open', function(){ console.log( 'open' ); } );
			// meny.addEventListener( 'close', function(){ console.log( 'close' ); } );

			// Embed an iframe if a URL is passed in
			if( Meny.getQuery().u && Meny.getQuery().u.match( /^http/gi ) ) {
				var contents = document.querySelector( '.contents' );
				contents.style.padding = '0px';
				contents.innerHTML = '<div class="cover"></div><iframe src="'+ Meny.getQuery().u +'" style="width: 100%; height: 100%; border: 0; position: absolute;"></iframe>';
			}
		</script>
</body>
</html>