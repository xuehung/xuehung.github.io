`find . -type f -name "FILE-TO-FIND" -exec rm -f {} \;`

# find total size
find /sem/data/querytool -type f -ctime -2 -print0 | du --files0-from=- -hc | tail -n1
