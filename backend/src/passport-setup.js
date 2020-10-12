const passport = require('passport');
const GoogleStrategy = require('passport-google-oauth20').Strategy;

passport.serializeUser(function(user, done){
    done(null, user);
});

passport.deserializeUser(function(user, done) {
    done(null, user);
});


passport.use(new GoogleStrategy({
    clientID : "131019455473-6sg6p0j8egc3jboc0sf8t2717i3jofu2.apps.googleusercontent.com",
    clientSecret : "Kelhco06-Y-_pZoJQ-Uyt49H",
    callbackURL : "http://localhost:3333/google/callback"
    },
    function(accessToken, refreshToken, profile, done)  {
        return done(null, profile);
    }

));