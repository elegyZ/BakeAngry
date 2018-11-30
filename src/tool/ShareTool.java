package tool;

import java.util.List;

import com.app.bakeangry.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

public class ShareTool 
{
	private final static String WECHAT_PKG = "com.tencent.mm";
	private final static String WECHAT_TO_TIMELINE = "com.tencent.mm.ui.tools.ShareToTimeLineUI";
	
	private static boolean isPackageAvilible(Context context, String packageName)
	{
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pkgInfoList = packageManager.getInstalledPackages(0);
        for(PackageInfo pkgInfo : pkgInfoList)
        {
        	if(pkgInfo.packageName.equalsIgnoreCase(packageName))
        		return true;
        }
        return false;
	}
	
	public static boolean isNetPingUsable()
	{
        Runtime runtime = Runtime.getRuntime();
        try 
        {
            Process process = runtime.exec("ping -c 3 www.baidu.com");
            int ret = process.waitFor();
            if (ret == 0)
            	return true;
            else
            	return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
	
	public static void ShareToWechatTimeLine(Activity activity, Bitmap bmp)
	{
		if(isPackageAvilible(activity, WECHAT_PKG))
		{
			if(isNetPingUsable())
			{
				Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(activity.getContentResolver(), bmp, null,null));
				Intent shareIntent = new Intent();
				ComponentName comp = new ComponentName(WECHAT_PKG, WECHAT_TO_TIMELINE);
				shareIntent.setComponent(comp);
				shareIntent.setAction(Intent.ACTION_SEND);
				shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
				shareIntent.setType("image/*");
				activity.startActivity(Intent.createChooser(shareIntent, "Share Photo"));
				activity.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
			}
			else
				Toast.makeText(activity, "Sorry, You Have Not Connected To The Internet, Please Check.", Toast.LENGTH_SHORT).show();
		}
		else
			Toast.makeText(activity, "Sorry, You Have Not Install Wechat, Please Check.", Toast.LENGTH_SHORT).show();
	}
}
