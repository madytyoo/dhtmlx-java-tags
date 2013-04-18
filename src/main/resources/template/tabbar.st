$if(attachment)$
    $if(openAttachment)$
    $attachment$.open();
    $endif$
    $if(mode)$
        $name$ = $attachment$.attachTabbar('$mode$');
    $else$
        $name$ = $attachment$.attachTabbar();
    $endif$

$else$
    $if(mode)$
        $name$ = new dhtmlXTabBar( $id$ , '$mode$' );
    $else$
        $name$ = new dhtmlXTabBar( $id$ );
    $endif$
$endif$

$if(skin)$
$name$.setSkin('$skin$');
$endif$

$if(imagePath)$
$name$.setImagePath('$imagePath$');
$endif$



$if(hrefMode)$
$name$.setHrefMode('$hrefMode$');
$endif$

$if(iframesOnDemand)$
$name$.setHrefMode("iframes-on-demand");
$endif$

$if(enableCloseButton)$
$name$.enableTabCloseButton(true);
$endif$

$if(onSelect)$
$name$.attachEvent('onSelect', $onSelect$ );
$endif$

$if(onTabClose)$
$name$.attachEvent('onTabClose', $onTabClose$ );
$endif$

$if(onTabContentLoaded)$
$name$.attachEvent('onTabContentLoaded', $onTabContentLoaded$ );
$endif$

$if(onXLS)$
$name$.attachEvent('onXLS', $onXLS$ );
$endif$

$if(onXLE)$
$name$.attachEvent('onXLE', $onXLE$ );
$endif$



$if(xml)$
$name$.loadXML('$xml$');
$else$
$tabs$
$endif$

$if(tabActive)$
$name$.setTabActive('$tabActive$');
$endif$




