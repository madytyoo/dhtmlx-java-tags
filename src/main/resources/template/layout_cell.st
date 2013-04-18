$if(id)$
$layout$.cells('$name$').attachObject('$id$');
$endif$

$if(url)$
$layout$.cells('$name$').attachURL('$url$');
$endif$

$if(text)$
$layout$.cells('$name$').setText('$text$');
$endif$

$if(width)$
$layout$.cells('$name$').setWidth('$width$');
$endif$

$if(height)$
$layout$.cells('$name$').setHeight('$height$');
$endif$

$if(fix)$
$layout$.cells('$name$').fixSize($fixWidth$,$fixHeight$);
$endif$

$if(hideHeader)$
$layout$.cells('$name$').hideHeader();
$endif$

