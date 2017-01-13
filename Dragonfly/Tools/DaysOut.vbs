Option Explicit
On Error Resume Next
Dim varResult
Dim varInput
varInput = InputBox("Enter a positive or negative integer to return a date from today or enter a date to return an integer")
If varInput <> "" Then
    varResult = DATADaysOut(varInput)
    If varResult = "please enter an integer or date" Then
        MsgBox varResult
    Else
        MsgBox varResult & " was copied to the clipboard."
        SetClipboard varResult
    End If
End If
On Error GoTo 0

Sub SetClipboard(strText)
    On Error Resume Next
    Dim strFile
    Dim objFile
    Dim objWsh
    Dim objFSO
    Set objFSO = CreateObject("Scripting.FileSystemObject")
    Set objWsh = CreateObject("WScript.Shell")
    strFile = objWsh.ExpandEnvironmentStrings("%TEMP%")
    If strFile = "%TEMP%" Then strFile = "."
    strFile = strFile & "~SetClipboard.hta"
    If Not objFSO.FileExists(strFile) Then
        Set objFile = objFSO.CreateTextFile(strFile, True)
        objFile.WriteLine "<HTA:APPLICATION id=c APPLICATIONNAME=/><SCRIPT language=VBScript>" & "document.parentwindow.clipboardData.SetData ""text""," & "Right(C.commandLine,Len(c.commandLine)-InStr(2,c.commandLine,Chr(34))-1):window.close" & "</SCRIPT></HTA:APPLICATION>"
        objFile.Close: Set objFile = Nothing
    End If
    objWsh.Run strFile & " " & strText, 0, True
    On Error GoTo 0
End Sub

Function DATADaysOut(varInput)
    On Error Resume Next
    If IsDate(varInput) = False Then
        If IsNumeric(varInput) = True Then
            DATADaysOut = DateAdd("d", varInput, Date)
        Else
            DATADaysOut = "please enter an integer or date"
            On Error GoTo 0
            Exit Function
        End If
    Else
        DATADaysOut = DateDiff("d", Date, varInput)
    End If
    On Error GoTo 0
End Function
