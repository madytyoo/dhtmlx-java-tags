$if(script)$
<script type="text/javascript" language="JavaScript">
$endif$
    $if(imagePath)$
    var globalImagePath = '$imagePath$';
    $endif$
    $if(vars)$
    var $vars$
    $endif$

    /* Component initialization */
    function $name$(param) {
        try {
            $if(imagePath)$
            window.dhx_globalImgPath = '$imagePath$';
            $endif$

            $code$

        
        } catch(err) {
              alert("**** : Exception : [" + err.name + "] " + err.message);
        }

    }
    /* Component initialization */    
$if(script)$
</script>
$endif$

