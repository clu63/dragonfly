ChangeIEZoom

Function ChangeIEZoom
 Dim intZoomLevel, objIE
 intZoomLevel = 100
 Const OLECMDID_OPTICAL_ZOOM = 63
 Const OLECMDEXECOPT_DONTPROMPTUSER = 2
 Set objIE = CreateObject("InternetExplorer.Application")
 objIE.Visible = True
 'objIE.Navigate "http://www.google.com"
objIE.Navigate "about:blank"
 While objIE.Busy = True
 WScript.Sleep 100
 Wend
 objIE.ExecWB OLECMDID_OPTICAL_ZOOM, OLECMDEXECOPT_DONTPROMPTUSER, CLng(intZoomLevel), vbNull

objIE.quit
 End Function