package factory.creator;

import factory.product.AbsPrintProfile;
import factory.product.PrintProfile;

public class AbsProfileFactory extends PrintProfileFactory {
    @Override
    public PrintProfile createProfile() {
        return new AbsPrintProfile();
    }
}