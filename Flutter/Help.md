# Settejar el path

**A macos**
export PATH="/Users/$USER/Documents/GitHub/flutter/bin:$PATH"

**A linux**
export PATH="/home/$USER/Documents/GitHub/flutter/bin:$PATH"

### Afegir el projecte "desktop"

flutter config --enable-macos-desktop
flutter create .
flutter run -d macos

**Nota**: Canviar *"macos"* per "linux" o "windows" si cal