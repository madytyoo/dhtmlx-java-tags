$if(text)$
    $accordion$.addItem('$name$', '$text$');
$else$
    $accordion$.addItem('$name$', '');
$endif$

$if(id)$
$accordion$.cells('$name$').attachObject('$id$');
$endif$

$if(url)$
$accordion$.cells('$name$').attachURL('$url$');
$endif$

