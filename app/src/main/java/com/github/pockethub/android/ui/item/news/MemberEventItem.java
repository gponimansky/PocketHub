package com.github.pockethub.android.ui.item.news;

import android.support.annotation.NonNull;
import android.view.View;

import com.github.pockethub.android.ui.StyledText;
import com.github.pockethub.android.ui.view.OcticonTextView;
import com.github.pockethub.android.util.AvatarLoader;
import com.meisolsson.githubsdk.model.GitHubEvent;
import com.meisolsson.githubsdk.model.payload.MemberPayload;

public class MemberEventItem extends NewsItem {

    public MemberEventItem(AvatarLoader avatarLoader, GitHubEvent dataItem) {
        super(avatarLoader, dataItem);
    }

    @Override
    public void bind(@NonNull NewsItem.ViewHolder viewHolder, int position) {
        super.bind(viewHolder, position);
        viewHolder.icon.setText(OcticonTextView.ICON_ADD_MEMBER);

        MemberPayload payload = (MemberPayload) getData().payload();

        StyledText main = new StyledText();
        boldActor(main, getData());
        main.append(" added ");
        main.bold(payload.member().login());
        main.append(" as a collaborator to ");
        boldRepo(main, getData());

        viewHolder.event.setText(main);
        viewHolder.details.setVisibility(View.GONE);
    }
}
