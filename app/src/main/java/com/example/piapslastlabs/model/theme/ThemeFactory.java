package com.example.piapslastlabs.model.theme;

import com.example.piapslastlabs.R;
import com.example.piapslastlabs.model.Theme;
import com.example.piapslastlabs.model.ThemeType;

public class ThemeFactory {

    public static Theme createTheme (ThemeType tt){

        Theme theme = null;

        switch (tt) {
            case SPORT:
                theme = new SportTheme();
                theme.setImage(R.drawable.icon_sport);
                break;

            case ART:
                theme =  new ArtTheme();
                theme.setImage(R.drawable.icon_art);
                break;

            case HISTORY:
                theme = new HistoryTheme();
                theme.setImage(R.drawable.icon_history);
                break;

            case SCIENCE:
                theme = new ScienceTheme();
                theme.setImage(R.drawable.icon_sciense);
                break;

            case GEOGRAPHY:
                theme = new GeographyTheme();
                theme.setImage(R.drawable.icon_map);
                break;

            case ENTERTAINMENT:
                theme = new EntertainmentTheme();
                theme.setImage(R.drawable.icon_entertinment);
                break;
        }

        return theme;
    }

}
