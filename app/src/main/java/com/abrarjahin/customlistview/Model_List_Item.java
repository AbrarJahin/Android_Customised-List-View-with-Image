package com.abrarjahin.customlistview;


public class Model_List_Item                                                                              //Update here////////////////////
{
    private  String CompanyName="";
    private  int Image;
    private  String Url="";

    /*********** Set Methods ******************/
    public void setCompanyName(String CompanyName)
    {
        this.CompanyName = CompanyName;
    }

    public void setImage(int Image)
    {
        this.Image = Image;
    }

    public void setUrl(String Url)
    {
        this.Url = Url;
    }

    /*********** Get Methods ****************/
    public String getCompanyName()
    {
        return this.CompanyName;
    }

    public int getImage()
    {
        return this.Image;
    }

    public String getUrl()
    {
        return this.Url;
    }
}
