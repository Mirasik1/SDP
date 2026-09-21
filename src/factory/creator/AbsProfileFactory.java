package factory.creator;

import factory.product.AbsPrintProfile;
import factory.product.IPrintProfile;

public class AbsProfileFactory extends PrintProfileFactory {
    @Override
    public IPrintProfile createProfile() {
        return new AbsPrintProfile();
    }
}