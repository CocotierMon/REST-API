call runcrud
if "%ERRORLEVEL%" == "0" goto chrome
echo.
echo RUNCRUD has errors - breaking work
goto fail

:chrome
start "Google Chrome" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Opening browser failed
goto fail

:fail
echo.
echo There were errors