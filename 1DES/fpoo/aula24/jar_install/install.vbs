ZipFile = "Hortelino.zip"
ExtractTo = "c:\"
Set ObjShell = CreateObject("Shell.Application")
Set FilesInZip=ObjShell.NameSpace(ZipFile).items
Set FSO = CreateObject("Scripting.FileSystemObject")
ObjShell.NameSpace(ExtractTo).CopyHere(FilesInZip)
Set FSO = Nothing: Set ObjShell = Nothing

set WshShell = WScript.CreateObject("WScript.Shell")
strDesktop = WshShell.SpecialFolders("Desktop")
set Hortelino = WshShell.CreateShortcut(strDesktop & "\Hortelino.lnk")
Hortelino.TargetPath = "C:\Hortelino\Hortelino.jar"
Hortelino.IconLocation = "C:\Hortelino\img\fundo.ico"
Hortelino.Description = "Atalho para Hortelino"
Hortelino.WorkingDirectory = "C:\Hortelino\"
Hortelino.Save