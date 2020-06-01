package now.lock;

import android.app.*;
import android.app.admin.*;
import android.content.*;
import android.os.*;

public class aMain extends Activity
{

	private ComponentName cn;

	@Override
	public void onCreate(Bundle sis)
	{
		super.onCreate(sis);
		DevicePolicyManager dpm=(DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
		cn = new ComponentName(this, rAdmin.class);
		toLock();
		finish();
		if (dpm.isAdminActive(cn))
		{
			dpm.lockNow();
			finish();
			return;
		}
	}

	private void toLock()
	{
		Intent i=new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		i.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, cn);
		i.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "开发者：Now");
		startActivity(i);
	}

}
