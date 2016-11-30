package util;

import model.City;
import model.County;
import model.MagcyangWeatherDB;
import model.Province;
import android.text.TextUtils;

public class Utility {
	public synchronized static boolean handleProvincesResponse(MagcyangWeatherDB magcyangWeatherDB,
			String response)	{
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces=response.split(",");
			if(allProvinces!=null && allProvinces.length>0){
				for(String p: allProvinces){
					String[] array=p.split("\\|");
					Province province=new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					magcyangWeatherDB.saveProvince(province);
				}
				return true;
			}
			
		}
		return false;
	}
	
	
	public synchronized static boolean handleCitiesResponse(MagcyangWeatherDB magcyangWeatherDB,
			String response,int provinceId)	{
		if(!TextUtils.isEmpty(response)){
			String[] allCities=response.split(",");
			if(allCities!=null && allCities.length>0){
				for(String p: allCities){
					String[] array=p.split("\\|");
					City city=new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					magcyangWeatherDB.saveCity(city);
				}
				return true;
			}
			
		}
		return false;
	}	
	
	public synchronized static boolean handleCountiesResponse(MagcyangWeatherDB magcyangWeatherDB,
			String response,int cityId)	{
		if(!TextUtils.isEmpty(response)){
			String[] allCounties=response.split(",");
			if(allCounties !=null && allCounties.length>0){
				for(String p: allCounties){
					String[] array=p.split("\\|");
					County county=new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					magcyangWeatherDB.saveCounty(county);
				}
				return true;
			}
			
		}
		return false;
	}		
	
}
