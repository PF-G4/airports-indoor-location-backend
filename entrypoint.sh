#!/bin/bash

echo "-> Starting...."
echo ""

cd "$APP_PATH"

start () {
    java -jar target/airports-indoor-location-backend-0.1.0.jar   # Separar por env levantando un puerto distinto (en caso de tener ambiente de test)
}

shell () {
    sh
}

COMMAND=$1; shift
case $COMMAND in
    start)
        start #$*
    ;;
    shell)
        shell $*
    ;;
    *)
        echo "[!] Invalid or command has not specified. Available commands: start, shell"
        exit 1
    ;;
esac

exit $?
