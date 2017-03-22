#### print single quota
awk -F"," -v sq="'" '{print "xxx",sq$1sq}' < inputfile.csv
awk -F"," '{print "\47xxx\47"}' < inputfile.csv
42 for double quota
