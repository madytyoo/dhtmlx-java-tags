$if(attachment)$
    $if(openAttachment)$
        $attachment$.open();
    $endif$
    $name$ = $attachment$.attachStatusBar( );
$endif$
