$if(attachment)$
    $if(openAttachment)$
    $attachment$.open();
    $endif$
    $name$ = $attachment$.attachLayout( '$pattern$' );
$else$
    $name$ = new dhtmlXLayoutObject( $id$ , '$pattern$' );
    $cells$
$endif$

$if(onResize)$
$name$.attachEvent('onResize', $onResize$ );
$endif$

$if(onExpand)$
$name$.attachEvent('onExpand', $onExpand$ );
$endif$

$if(onCollapse)$
$name$.attachEvent('onCollapse', $onCollapse$ );
$endif$

$if(onPanelResize)$
$name$.attachEvent('onPanelResizeFinish', $onPanelResize$ );
$endif$

$if(onContentLoaded)$
$name$.attachEvent('onContentLoaded', $onContentLoaded$ );
$endif$

$if(onDock)$
$name$.attachEvent('onDock', $onDock$ );
$endif$

$if(onUnDock)$
$name$.attachEvent('onUnDock', $onUnDock$ );
$endif$

$if(onDblClick)$
$name$.attachEvent('onDblClick', $onDblClick$ );
$endif$
