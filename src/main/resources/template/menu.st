$if(attachment)$
    $if(tree)$
        $name$ = new dhtmlXMenuObject();
        $name$.renderAsContextMenu();
        $attachment$.attachEvent("onRightClick", function(id, e){
            var x = e.clientX;
            var y = e.clientY;
            window.setTimeout(function(){
                $name$.showContextMenu(x,y);
            },1);
            return false;
        });


    $else$
        $if(contextual)$
            $name$ = new dhtmlXMenuObject();
            $name$.renderAsContextMenu();
            $attachment$.enableContextMenu($name$);
        $else$
            $name$ = $attachment$.attachMenu();
        $endif$
    $endif$


$else$
    $name$ = new dhtmlXMenuObject( $id$  );
$endif$

$if(iconsPath)$
$name$.setIconsPath('$iconsPath$');
$endif$

$if(openMode)$
$name$.setOpenMode('$openMode$');
$endif$

$if(align)$
$name$.setAlign('$align$');
$endif$


$if(xml)$
$name$.loadXML('$xml$');
$else$
$items$
$endif$

$if(onClick)$
$name$.attachEvent('onClick', $onClick$ );
$endif$

$if(onCheckboxClick)$
$name$.attachEvent('onCheckboxClick', $onCheckboxClick$ );
$endif$

$if(onRadioClick)$
$name$.attachEvent('onRadioClick', $onRadioClick$ );
$endif$

$if(onBeforeContextMenu)$
$name$.attachEvent('onBeforeContextMenu', $onBeforeContextMenu$ );
$endif$

$if(onAfterContextMenu)$
$name$.attachEvent('onBeforeContextMenu', $onAfterContextMenu$ );
$endif$

$if(onXLS)$
$name$.attachEvent('onXLS', $onXLS$ );
$endif$

$if(onXLE)$
$name$.attachEvent('onXLE', $onXLS$ );
$endif$

