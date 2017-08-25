package biz.cccm.mgmt.registration.action;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import biz.cccm.dao.SearchException;
import biz.cccm.mgmt.registration.model.Registrant;
import biz.cccm.mgmt.registration.service.RegistrantManager;
import biz.cccm.webapp.action.BasePage;
import ws.cccm.reg.service.NameTag;
import ws.cccm.reg.service.NameTagService;
import ws.cccm.reg.service.NameTagServiceImpl;

public class NametagList extends BasePage implements Serializable {

    private static final long serialVersionUID = 972359310602754020L;
    protected RegistrantManager registrantManager;
    private List<Registrant> registrants;
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setRegistrantManager(RegistrantManager registrantManager) {
        this.registrantManager = registrantManager;
    }

    public NametagList() {
        setSortColumn("familyID");
    }

    public List getRegistrants() {
        try {
            registrants = sort(registrantManager.search(query));
            return registrants;
        } catch (SearchException se) {
            addError(se.getMessage());
            return sort(registrantManager.search(query));
        }
    }

    public String search() {
        return "success";
    }

    public String print() {

        try {
            Set<NameTag> printRequest = new LinkedHashSet<>();
            for (Registrant reg : registrants) {

                NameTag nameTag = new NameTag();
                if (reg.getChineseName() != null && !reg.getChineseName().isEmpty()) {
                    nameTag.setChineseFullName(reg.getChineseName());
                } else {
                    nameTag.setChineseFullName(reg.getFirstName()) ;
                }
                nameTag.setEnglishFullName(reg.getFirstName() + " " + reg.getLastName());
                nameTag.setChruchName(reg.getChurchName());
                nameTag.setCenterId(reg.getRegistrationID());
                nameTag.setAddress(reg.getHomeCity() + "," + reg.getHomeState());
                nameTag.setBarcodeId(String.valueOf(reg.getPersonID()));
                
                if (reg.getPreferredLanguage().equalsIgnoreCase("E")) {
                    nameTag.setGrace(true);
                }
                printRequest.add(nameTag);
            }
            NameTagService nameTagService = new NameTagServiceImpl();
            byte[] pdf = nameTagService.generateNameTagPrints(printRequest, 8);

//        if (!Files.notExists(Paths.get("C:\\Temp\\nametag.pdf"))) {
//            Files.delete(Paths.get("C:\\Temp\\nametag.pdf"));
//        }
//        Files.write(Paths.get("C:\\Temp\\nametag.pdf"), pdf, StandardOpenOption.CREATE_NEW);
//            File file = new File("C:\\Temp\\nametag.pdf");
//            InputStream fis = new FileInputStream(file);
//            byte[] buf = new byte[1024];
//            int offset = 0;
//            int numRead = 0;
//            while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) {
//                offset += numRead;
//            }
//            fis.close();
            HttpServletResponse response
                    = (HttpServletResponse) FacesContext.getCurrentInstance()
                    .getExternalContext().getResponse();

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=nametag.pdf");
            response.getOutputStream().write(pdf);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PersonForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "success";
    }

}
