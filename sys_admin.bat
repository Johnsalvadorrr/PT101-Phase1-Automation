@echo off
TITLE Student Computer Utility v1.0
COLOR 0A

SET LOG_DIR=C:\Logs
IF NOT EXIST "%LOG_DIR%" MKDIR "%LOG_DIR%"
SET LOG_FILE=%LOG_DIR%\student_diag.log

:MENU
CLS
ECHO ====================================================
ECHO      STUDENT COMPUTER UTILITY ^& DIAGNOSTICS
ECHO ====================================================
ECHO [1] View Network Details (ipconfig)
ECHO [2] Test Connectivity (ping)
ECHO [3] View Active Processes (tasklist)
ECHO [4] View ^& Backup Logs (dir / copy)
ECHO [5] Delete Backup Logs (del)
ECHO [6] Exit
ECHO ====================================================
SET /P CHOICE=Select an option [1-6]: 

IF "%CHOICE%"=="1" GOTO NET_CONFIG
IF "%CHOICE%"=="2" GOTO TEST_PING
IF "%CHOICE%"=="3" GOTO TASK_LIST
IF "%CHOICE%"=="4" GOTO BACKUP_LOG
IF "%CHOICE%"=="5" GOTO CLEAN_LOGS
IF "%CHOICE%"=="6" EXIT

ECHO.
ECHO [!] Invalid choice. Try again.
PAUSE
GOTO MENU

:NET_CONFIG
CLS
ipconfig /all
ECHO [INFO] Network config checked at %DATE% %TIME% >> "%LOG_FILE%"
ipconfig /all >> "%LOG_FILE%"
PAUSE
GOTO MENU

:TEST_PING
CLS
SET TARGET=google.com
ping %TARGET%
IF ERRORLEVEL 1 (
    ECHO [ERROR] Ping failed at %DATE% %TIME% >> "%LOG_FILE%"
) ELSE (
    ECHO [SUCCESS] Ping succeeded at %DATE% %TIME% >> "%LOG_FILE%"
)
PAUSE
GOTO MENU

:TASK_LIST
CLS
tasklist
ECHO [INFO] Process list captured at %DATE% %TIME% >> "%LOG_FILE%"
tasklist >> "%LOG_FILE%"
PAUSE
GOTO MENU

:BACKUP_LOG
CLS
dir "%LOG_DIR%"
ECHO.
IF EXIST "%LOG_FILE%" (
    IF NOT EXIST "%LOG_DIR%\Backup" MKDIR "%LOG_DIR%\Backup"
    copy "%LOG_FILE%" "%LOG_DIR%\Backup\sys_diag_backup.log" /Y
    ECHO [+] Backup created successfully.
) ELSE (
    ECHO [!] No log file found. Run options 1-3 first.
)
PAUSE
GOTO MENU

:CLEAN_LOGS
CLS
IF EXIST "%LOG_DIR%\Backup\sys_diag_backup.log" (
    del "%LOG_DIR%\Backup\sys_diag_backup.log"
    ECHO [+] Backup log file deleted.
) ELSE (
    ECHO [!] No backup log file to delete.
)
PAUSE
GOTO MENU
