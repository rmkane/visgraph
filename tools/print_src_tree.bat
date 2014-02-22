@echo off
setlocal enableDelayedExpansion
cls

set THIS_DIR=%~dp0
set TREE_FILE=src_tree.txt
set REMOTE_PATH=https://github.com/ryankane/visgraph/blob/master/src
set LOCAL_PATH=\Users\%USERNAME%\workspace\visgraph\src

:: Print out the current tree structure.
tree ..\src /f /a > %TREE_FILE%

echo Files: >> %TREE_FILE%
echo. >> %TREE_FILE%

cd ..\src
for /r %%F in (*) do (
    :: Get filename with extention and path.
    set fpath=%%~pnxF
	call set fname=%%fpath:!LOCAL_PATH!=%%
    :: Replace the local path with the remote path.
    call set fpath=%%fpath:!LOCAL_PATH!=!REMOTE_PATH!%%
    :: Replace all backslashes with forward slashes.
    call set fpath=%%fpath:\=/%%
    :: Markdown link.
	set line=* [!fname!]^(!fpath!^)
	echo !line!
    echo !line! >> "%THIS_DIR%\%TREE_FILE%"
)
cd %THIS_DIR%

