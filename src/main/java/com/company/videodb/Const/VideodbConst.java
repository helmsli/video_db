package com.company.videodb.Const;

public class VideodbConst {
	
	//范围5001 到5100
	//成功
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_FAILURE = 5001;
    
    public static final int RESULT_Error_startCode = 5002;
    
    public static final int RESULT_Error_Crc = RESULT_Error_startCode+0;
    public static final int RESULT_Error_dbNotExist = RESULT_Error_startCode+1;
      
}
