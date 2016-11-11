varInput =InputBox("Enter an positive or negative integer to return a date from today or enter a date to return an integer")

msgbox DATADaysOut(varInput)
 

Function DATADaysOut(varInput)
    On Error Resume Next
    DATADaysOut = varInput
    If IsDate(varInput) = False Then
        If IsNumeric(varInput) = True Then
			DATADaysOut = DateAdd("d", varInput, Date)
        Else
        	DATADaysOut = "please enter an integer or date"
        End If
    Else
    	DATADaysOut = DateDiff("d", Date, varInput)
    End If
    On Error GoTo 0
End Function