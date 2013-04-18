
$if(attachment)$
    $if(openAttachment)$
        $attachment$.open();
    $endif$
    $name$ = $attachment$.attachChart( {
    view:"$view$",

    value:"$value$",

    $if(label)$
    label:"$label$",
    $endif$

    $if(tooltip)$
    tooltip: "$tooltip$",
    $endif$

    $if(alpha)$
    alpha: "$alpha$",
    $endif$

    $if(color)$
    color: "$color$",
    $endif$

    $if(item)$
    $item$
    $endif$

    $if(line)$
    $line$
    $endif$

    $if(padding)$
    $padding$
    $endif$

    $if(legend)$
    $legend$
    $endif$

    $axis_x$
    $axis_y$
} );
$else$
    $name$ = new dhtmlXChart( {
    view:"$view$",

    $if(id)$
    container: "$id$",
    $endif$

    value:"$value$",

    $if(label)$
    label:"$label$",
    $endif$

    $if(tooltip)$
    tooltip: "$tooltip$",
    $endif$

    $if(item)$
    $item$
    $endif$

    $if(line)$
    $line$
    $endif$

    $if(padding)$
    $padding$
    $endif$

    $if(legend)$
    $legend$
    $endif$

    $axis_x$
    $axis_y$
});
$endif$


