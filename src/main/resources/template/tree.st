$if(attachment)$
    $if(openAttachment)$
    $attachment$.open();
    $endif$
    $name$ = $attachment$.attachTree( );
$else$
    $name$ = new dhtmlXTreeObject( '$id$', '$width$' , '$height$' , '$root$' );
$endif$


$if(skin)$
$name$.setSkin('$skin$');
$endif$

$if(imagePath)$
$name$.setImagePath('$imagePath$');
$endif$

$if(onXLS)$
$name$.attachEvent('onXLS', $onXLS$ );
$endif$

$if(onXLE)$
$name$.attachEvent('onXLE', $onXLE$ );
$endif$

$if(onSelect)$
$name$.attachEvent('onSelect', $onSelect$ );
$endif$

$if(onClick)$
$name$.attachEvent('onClick', $onClick$ );
$endif$

$if(onDblClick)$
$name$.attachEvent('onDblClick', $onDblClick$ );
$endif$

$if(xml)$
$name$.loadXML('$xml$');
$endif$



