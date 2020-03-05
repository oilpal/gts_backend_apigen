package com.neofect.gts.core.services.attach.service;

import java.util.HashMap;
import java.util.Map;

import com.unvus.services.attach.domain.AttachRoom;
import com.unvus.services.attach.domain.AttachRoomImpl;

public class ReferenceTypeRegistry {
    public static final String _DEFAULT_CABINET_NAME = "default";

    protected static Map<String, AttachRoom> roomMap = new HashMap();

    public static AttachRoom get(String type) {
        return roomMap.containsKey(type)?roomMap.get(type):createDefaultRoom(type);
    }

    public static void add(String type, AttachRoom referenceType) {
        roomMap.put(type, referenceType);
    }

    protected static AttachRoom createDefaultRoom(String roomName) {
        AttachRoom room = new AttachRoomImpl() {
            @Override
            public String getRoomName() {
                return roomName;
            }
        };

        room.addCabinet(_DEFAULT_CABINET_NAME);

        roomMap.put(roomName, room);

        return room;
    }

    /** CK 에디터 */
    public static AttachRoom CKEDITOR = createDefaultRoom("ckeditor");
    public static AttachRoom BOARD_POST = createDefaultRoom("board_post");
    public static AttachRoom FILE_MANAGE = createDefaultRoom("file_manage");
    public static AttachRoom AGENCY = createDefaultRoom("agency");
    public static AttachRoom HELPDESK = createDefaultRoom("helpdesk");

}
