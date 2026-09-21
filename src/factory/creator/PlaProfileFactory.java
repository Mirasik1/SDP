package factory.creator;

import factory.product.PlaPrintProfile;
import factory.product.IPrintProfile;

public class PlaProfileFactory extends PrintProfileFactory {
    @Override
    public IPrintProfile createProfile() {
        return new PlaPrintProfile();
    }
}