#### print single quota
awk -F"," -v sq="'" '{print "xxx",sq$1sq}' < inputfile.csv
