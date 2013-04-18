$if(width)$
$tabbar$.addTab('$name$','$text$','$width$');
$else$
$tabbar$.addTab('$name$','$text$');
$endif$


$if(id)$
$tabbar$.setContent('$name$','$id$');
$endif$

$if(url)$
$tabbar$.setContentHref('$name$', '$url$');
$endif$
