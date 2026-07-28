package payloadBuilder;

import org.json.simple.JSONObject;

public class AnnouncementPayload {

    public static JSONObject createAnnouncementPayload(String title, String content) {
        JSONObject createAnnouncement = new JSONObject();
        createAnnouncement.put("title", title);
        createAnnouncement.put("content", content);

        return createAnnouncement;
    }

    public static JSONObject updateAnnouncementPayload(String title, String content, String isActive) {
        JSONObject updateAnnouncement = new JSONObject();
        updateAnnouncement.put("title", title);
        updateAnnouncement.put("content", content);
        updateAnnouncement.put("isActive", isActive);
        return updateAnnouncement;
    }


}
