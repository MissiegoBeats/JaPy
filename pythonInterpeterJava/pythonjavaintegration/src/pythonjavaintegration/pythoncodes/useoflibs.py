import sys

def useofsys():
    print("use of sys")
    print("Path: "+str(sys.path))
    print("Version: "+str(sys.version))
    print("Version info: "+str(sys.version_info))
    print("Executable: "+str(sys.executable))
    print("Platform: "+str(sys.platform))

useofsys()

#import pandas as pd

"""def useofpandas():
    print("use of pandas")
    df = pd.DataFrame({'col1': [1, 2], 'col2': [3, 4]})
    print(df)"""
