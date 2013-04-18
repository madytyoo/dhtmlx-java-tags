$if(attachment)$
    $if(openAttachment)$
    $attachment$.open();
    $endif$
    $name$ = $attachment$.attachToolbar( );
$else$
    $name$ = new dhtmlXToolbarObject( '$id$' );
$endif$


$if(iconsPath)$
$name$.setIconsPath('$iconsPath$');
$endif$

$if(onClick)$
$name$.attachEvent('onClick', $onClick$ );
$endif$

$if(onStateChange)$
$name$.attachEvent('onStateChange', $onStateChange$ );
$endif$

$if(onStateChange)$
$name$.attachEvent('onValueChange', $onValueChange$ );
$endif$

$if(onEnter)$
$name$.attachEvent('onEnter', $onEnter$ );
$endif$

$if(onXLS)$
$name$.attachEvent('onXLS', $onXLS$ );
$endif$

$if(onXLE)$
$name$.attachEvent('onXLE', $onXLS$ );
$endif$


$if(xml)$
$name$.loadXML('$xml$');
$else$
$items$
$endif$


