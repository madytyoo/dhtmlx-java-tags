$if(attachment)$
    $if(openAttachment)$
    $attachment$.open();
    $endif$
    $name$ = $attachment$.attachGrid( );
$else$
    $name$ = new dhtmlXGridObject( '$id$' );
$endif$


$if(skin)$
$name$.setSkin('$skin$');
$endif$

$if(imagePath)$
$name$.setImagePath('$imagePath$');
$endif$

$if(imgURL)$
$name$.imgURL = '$imageURL$';
$endif$


$if(onXLS)$
$name$.attachEvent('onXLS', $onXLS$ );
$endif$

$if(onXLE)$
$name$.attachEvent('onXLE', $onXLE$ );
$endif$

$if(onRowSelect)$
$name$.attachEvent('onRowSelect', $onRowSelect$ );
$endif$

$if(onRowDblClicked)$
$name$.attachEvent('onRowDblClicked', $onRowDblClicked$ );
$endif$

$if(xml)$
$name$.loadXML('$xml$');
$endif$

$if(init)$
$name$.setColumnIds('$ids$');
$name$.setHeader('$header$');
$name$.setColTypes('$type$');
$name$.setColAlign('$align$');
$name$.setColSorting('$sort$');
$name$.setInitWidths('$width$');
$name$.init();
$endif$





