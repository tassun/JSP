package com.fs.tag;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

@SuppressWarnings({"serial","rawtypes"})
public class Select extends BodyTagSupport {
	private String name = null;
	private String section = null;
public Select() {
	super();
}
public int doAfterBody() throws JspException {
	try {
		BodyContent body = getBodyContent();
		JspWriter out = body.getEnclosingWriter();
		StringBuffer outstr = new StringBuffer();
		outstr.append("<select name='");
		outstr.append(name);
		outstr.append("' ");
		outstr.append(">");
		BufferedReader contentReader = new BufferedReader(body.getReader());
		String rowread = "";
		StringBuffer item = new StringBuffer();
		while ((rowread = contentReader.readLine()) != null) {
			item.append(rowread.trim());
		}
		java.util.Map tree = null;
		if((getSection()!=null) && !getSection().equals("")) {
			tree = (java.util.Map)this.pageContext.getSession().getAttribute(getSection());
		}
		if((tree!=null) && !tree.isEmpty()) {
			java.util.Iterator it = tree.keySet().iterator();
			for(;it.hasNext();) {
				Object key = it.next();
				String value = (String)tree.get(key);
				if((key!=null) && (value!=null)) {				
					if(item.toString().equals(key.toString())) {
						outstr.append("<option value=\""+key+"\" selected>"+value+"</option>\n");
					} else {
						outstr.append("<option value=\""+key+"\">"+value+"</option>\n");
					}
				}
			}
		}
		outstr.append("</select>");
		if(outstr!=null){
			out.println(outstr.toString());
		}
	} catch (IOException e) {
		throw new JspTagException(e.toString());
	}
	return SKIP_BODY;
}

public String getName() {
	return name;
}
public String getSection() {
	return section;
}
public void setName(String newName) {
	name = newName;
}
public void setSection(String section) {
	this.section = section;
}
}
