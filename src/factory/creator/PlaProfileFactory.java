package factory.creator;

import factory.product.PlaPrintProfile;
import factory.product.PrintProfile;

public class PlaProfileFactory extends PrintProfileFactory {
    @Override
    public PrintProfile createProfile() {
        return new PlaPrintProfile();
    }
}