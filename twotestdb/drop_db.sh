




echo $PATH
DB_PATH=/tmp/applifire/db/S0JSME5B7DBZ4COVKBEI9Q/D7EFF9DA-2CEA-4032-A634-1C9EE42862FC
MYSQL=/usr/bin
USER=two
PASSWORD=two
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'