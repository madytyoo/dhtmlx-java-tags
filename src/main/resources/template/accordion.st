$if(attachment)$
$name$ = $attachment$.attachAccordion();
$else$
$name$ = new dhtmlXAccordion( $id$ );
$endif$


$if(mode)$
$name$.enableMultiMode(true);
$endif$


$if(onActive)$
$name$.attachEvent('onActive', $onActive$ );
$endif$

$if(onBeforeActive)$
$name$.attachEvent('onBeforeActive', $onBeforeActive$ );
$endif$

$if(onDock)$
$name$.attachEvent('onDock', $onDock$ );
$endif$

$if(onUnDock)$
$name$.attachEvent('onUnDock', $onUnDock$ );
$endif$

$cells$

$if(openItem)$
$name$.openItem( '$openItem$' );
$endif$


