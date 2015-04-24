package com.functions;

import java.io.IOException;

import com.fields.RequestMsg;
import com.fields.ResponseMsg;

public interface Handler {

	public ResponseMsg processTextTypeMsg(RequestMsg msg) throws IOException;

	public ResponseMsg processLocationTypeMsg(RequestMsg msg);

	public ResponseMsg processLinkTypeMsg(RequestMsg msg);

	public ResponseMsg processImageTypeMsg(RequestMsg msg);

	public ResponseMsg processEventTypeMsg(RequestMsg msg);

	public ResponseMsg processVoiceTypeMsg(RequestMsg msg);
}
