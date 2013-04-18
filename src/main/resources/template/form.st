var $name$_data = [
    $data$
];

$if(attachment)$
    $if(openAttachment)$
        $attachment$.open();
    $endif$
    $name$ = $attachment$.attachForm( $name$_data );
$else$
    $name$ = new dhtmlXForm( $id$ , $name$_data );
$endif$
