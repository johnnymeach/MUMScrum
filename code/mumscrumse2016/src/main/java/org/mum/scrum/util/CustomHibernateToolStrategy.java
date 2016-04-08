package org.mum.scrum.util;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategyUtil;
import org.hibernate.cfg.reveng.TableIdentifier;


public class CustomHibernateToolStrategy extends DelegatingReverseEngineeringStrategy {

	public CustomHibernateToolStrategy(ReverseEngineeringStrategy delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String tableToClassName(TableIdentifier tableIdentifier){
		final String defaultClassName = super.tableToClassName(tableIdentifier);
        final String packageName = this.extractPackageName(defaultClassName);
        
		String tableName="";
		if(tableIdentifier.getName().startsWith("sec_")){
			tableName = tableIdentifier.getName().substring(4);			
		}else if(tableIdentifier.getName().startsWith("tab")){
			tableName = tableIdentifier.getName().substring(3);
		}else{
			tableName = tableIdentifier.getName();
		}
		tableName=fromPlural(tableName);
	    return packageName+ReverseEngineeringStrategyUtil.toUpperCamelCase(tableName);
		
//		if packge field in code Generation config is blank add here instead
//	    return "com.pru.pruquote.entity."+ReverseEngineeringStrategyUtil.toUpperCamelCase(tableName);
	}
	
	public String fromPlural(String str)  
    {  
        if(shouldEndWithE(str)) return str.substring(0, str.toLowerCase().lastIndexOf("es"));  
        else if(str.toLowerCase().endsWith("s")) return str.substring(0, str.toLowerCase().lastIndexOf('s'));  
        else if(str.toLowerCase().endsWith("children")) return str.substring(0, str.toLowerCase().lastIndexOf("ren"));  
        else if(str.toLowerCase().endsWith("people")) return str.substring(0, str.toLowerCase().lastIndexOf("ople")) + "rson";  
        else return str;  
    }  
   
    /** 
     * 
     * @param str 
     * @return true is the singular form of a word should end with the letter "e" 
     */  
    private boolean shouldEndWithE(String str)  
    {  
        return str.toLowerCase().endsWith("iece")  
         || str.toLowerCase().endsWith("ice")  
         || str.toLowerCase().endsWith("ace")  
         || str.toLowerCase().endsWith("ise")  
                ;  
    }
    
    private String extractPackageName(String defaultClassName) {
        int lastIndex = defaultClassName.lastIndexOf(".");
        final String packageName = defaultClassName.substring(0, lastIndex + 1);
        return packageName;
    }
}

