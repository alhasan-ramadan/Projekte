import os
import shutil
import uuid
import json
import logging
from pathlib import Path
import argparse

def parse_args():
    parser = argparse.ArgumentParser(description="Organize your Downloads folder.")
    parser.add_argument('--dry-run', action='store_true', help="Show what would be moved without actually moving files.")
    return parser.parse_args()

def load_file_types(config_path):
    """Load file types from a JSON configuration file."""
    try:
        with open(config_path, 'r') as f:
            return json.load(f)
    except FileNotFoundError:
        logging.warning(f"Configuration file {config_path} not found. Using default file types.")
        return {
        'Images': ['.jpg', '.jpeg', '.png', '.gif', '.tiff', '.bmp', '.svg', '.ico'],
        'Documents': ['.pdf', '.docx', '.xlsx', '.pptx', '.txt', '.md', '.odt', '.rtf', '.csv'],
        'Audio': ['.mp3', '.wav', '.aac', '.flac', '.ogg', '.m4a'],
        'Videos': ['.mp4', '.mov', '.avi', '.mkv', '.wmv', '.flv'],
        'Archives': ['.zip', '.rar', '.tar.gz', '.7z', '.iso', '.log'],
        'Applications': ['.exe', '.msi', '.bat', '.sh', '.apk', '.app', '.deb', '.rpm'],
        'Programming': {
                'Python': ['.py', '.pyw'],
                'JavaScript': ['.js', '.jsx'],
                'Java': ['.java', '.class', '.jar'],
                'C/C++': ['.c', '.cpp', '.h', '.hpp', '.o'],
                'C#': ['.cs'],
                'Go': ['.go'],
                'Ruby': ['.rb'],
                'PHP': ['.php'],
                'HTML/CSS': ['.html', '.htm', '.css'],
                'SQL': ['.sql'],
                'Rust': ['.rs'],
                'Kotlin': ['.kt', '.kts'],
                'Swift': ['.swift'],
                'TypeScript': ['.ts', '.tsx'],
                'VHDL': ['.vhd', '.vhdl'],
                'GDScript': ['.gd', '.tres', '.gdshader', '.theme'],
                'Lua': ['.lua'],
                'Objective-C': ['.m', '.h'],
                'Shell': ['.sh', '.bash', '.zsh'],
                'Perl': ['.pl'],
                'R': ['.r'],
                'Dart': ['.dart'],
                'Elixir': ['.ex', '.exs'],
                'Julia': ['.jl'],
                'Haskell': ['.hs'],
                'Tcl': ['.tcl'],
                'VBScript': ['.vbs'],
                'ActionScript': ['.as'],
                'Assembly': ['.asm', '.s'],
                'F#': ['.fs', '.fsi'],
                'Scala': ['.scala'],
                'Groovy': ['.groovy'],
                'PowerShell': ['.ps1'],
                'CoffeeScript': ['.coffee'],
                'Prolog': ['.pl'],
                'Hack': ['.hh', '.php'],
                'Crystal': ['.cr'],
                'TypeScript': ['.ts', '.tsx'],
                'Vala': ['.vala'],
                'Zig': ['.zig'],
                'Scheme': ['.scm', '.ss'],
                'Smalltalk': ['.st']
            }

    }


def organize_downloads(download_folder, file_types, dry_run=False):
    """Organize files in the download folder based on their extensions."""
    log_file = os.path.join(download_folder, "file_moves.log")

    for file in os.listdir(download_folder):
        file_path = os.path.join(download_folder, file)

        if os.path.isfile(file_path):
            file_ext = os.path.splitext(file)[1].lower()

            # Durchsuchen der Dateiarten nach der passenden Erweiterung
            destination_folder = 'Others'  # Default in case no match is found

            # Durchsuchen der Kategorien nach der Erweiterung
            for ftype, exts in file_types.items():
                if isinstance(exts, dict):  # Für die Programming-Kategorie
                    for sub_category, sub_exts in exts.items():
                        if file_ext in sub_exts:
                            destination_folder = os.path.join(ftype, sub_category)
                            break
                elif file_ext in exts:  # Für alle anderen Kategorien
                    destination_folder = ftype
                    break

            os.makedirs(os.path.join(download_folder, destination_folder), exist_ok=True)

            destination_file = os.path.join(download_folder, destination_folder, file)

            # Wenn die Datei bereits existiert, füge eine UUID hinzu
            if os.path.exists(destination_file):
                base, ext = os.path.splitext(file)
                destination_file = os.path.join(download_folder, destination_folder, f"{base}_{uuid.uuid4().hex}{ext}")

            if dry_run:
                logging.info(f"[Dry-Run] Would move {file_path} to {destination_file}")
            else:
                try:
                    shutil.move(file_path, destination_file)
                    logging.info(f"Moved {file_path} to {destination_file}")

                    with open(log_file, 'a') as log:
                        log.write(f"{file_path} -> {destination_file}\n")
                except Exception as e:
                    logging.error(f"Error moving file {file_path}: {e}")


def remove_empty_folders(folder):
    """Remove empty folders in the specified directory."""
    for dirpath, dirnames, filenames in os.walk(folder, topdown=False):
        if not dirnames and not filenames:
            try:
                os.rmdir(dirpath)
                logging.info(f"Removed empty folder: {dirpath}")
            except Exception as e:
                logging.error(f"Error removing folder {dirpath}: {e}")

if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

    args = parse_args()

    downloads_path = str(Path.home() / "Downloads")  # Default downloads path
    config_path = "file_types.json"  # Path to the configuration file

    file_types = load_file_types(config_path)

    organize_downloads(downloads_path, file_types, dry_run=args.dry_run)

    if not args.dry_run:
        remove_empty_folders(downloads_path)

    logging.info("Downloads organization completed!")